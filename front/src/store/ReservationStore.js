import { action, makeObservable, observable } from "mobx";
import apiService from "../services/ApiService";

class ReservationStore {
  week = ["일", "월", "화", "수", "목", "금", "토"];
  dateInfo = {};
  today = new Date();
  currentDayInfo = {};
  gameList = [];

  constructor(rootStore) {
    this.rootStore = rootStore;
    makeObservable(this, {
      week: observable,
      dateInfo: observable,
      currentDayInfo: observable,
      today: observable,
      gameList: observable,
      daysArray: action,
      dateCalculation: action,
      searchGameList: action,
    });
  }

  init() {
    this.dateCalculation();
    this.searchGameList();
  }

  //다음달은 30일- 이번달 나온 일수로만 하기 2월 포함하는 경우는 28일까지만 윤년의 경우도 체크할 것
  dateCalculation() {
    let today = this.today;
    let nowLastDay = today.getMonth() + 1 in [1, 3, 5, 7, 8, 10, 12] ? 31 : 30;
    let nextLastDay = today.getMonth() + 2 in [1, 3, 5, 7, 8, 10, 12] ? 31 : 30;
    let dateInfo = {
      nowYear: today.getFullYear(),
      nextYear: today.getFullYear(),
      nowMonth: today.getMonth() + 1,
      nextMonth: today.getMonth() + 2,
      nowDays: [],
      nextDays: [],
      currentDay: today.getDate(),
    };

    if (dateInfo.nowMonth === 12) {
      dateInfo = { ...dateInfo, nextMonth: 1 };
      dateInfo = { ...dateInfo, nextYear: dateInfo.nowYear + 1 };
    } else {
      dateInfo = { ...dateInfo, nextMonth: dateInfo.nowMonth + 1 };
    }

    nowLastDay = dateInfo.nowMonth === 2 && this.leapYearCheck() ? 29 : 28;
    nextLastDay = dateInfo.nextMonth === 2 && this.leapYearCheck() ? 29 : 28;

    let nowDaysArray = Array.from({ length: nowLastDay }, (v, i) => i + 1);
    let nextDaysArray = Array.from({ length: nextLastDay }, (v, i) => i + 1);

    nowDaysArray = this.daysArray(nowDaysArray);
    nowDaysArray.days.splice(0, today.getDate() - 1);

    dateInfo.nowDays = nowDaysArray.days;
    let nextDayCnt = nowDaysArray.nextCnt; // 요일 index값
    dateInfo.nextDays = this.daysArray(nextDaysArray, nextDayCnt, true).days;

    const dayInfo = {
      day: today.getDate(),
      month: dateInfo.nowMonth,
      year: dateInfo.nowYear,
    };

    this.currentDayInfo = dayInfo;
    this.dateInfo = dateInfo;
  }

  //이번달 정보
  daysArray(
    days,
    nextDayCnt = this.today.getDay() - 1,
    nextMonthCheck = false
  ) {
    let startDayCnt = nextDayCnt;

    const newDays = days.map((Day, index) => {
      startDayCnt += 1;
      if (startDayCnt > 6) {
        startDayCnt = 0;
      }
      return {
        date: Day,
        day: this.week[startDayCnt],
      };
    });
    return {
      days: newDays,
      nextCnt: startDayCnt > 6 ? 1 : startDayCnt + 1,
      length: newDays.length,
    };
  }

  //윤년체크
  leapYearCheck() {
    const nowYear = this.today.getFullYear;
    if (nowYear % 4 === 0 && nowYear % 100 !== 0) {
      return true;
    } else if (
      nowYear % 4 === 0 &&
      nowYear % 100 === 0 &&
      nowYear % 400 === 0
    ) {
      return true;
    }
    return false;
  }

  changeData(key, value) {
    this[key] = value;
  }

  searchGameList() {
    const dayInfo = this.currentDayInfo;
    const apiParam = {
      ...dayInfo,
    };

    apiService
      .get("games", apiParam)
      .then(({ data }) => {
        console.log(data);
        this.gameList = data;
      })
      .catch(({ response }) => {
        console.log(response);
      });
  }

  gameApplyAndCancel(game) {
    const email = this.rootStore.appStore.email;
    const apiParam = {
      ...game,
      email: email,
    };

    if (game.email === email) {
      apiService
        .post("game-apply/cancel", apiParam)
        .then((response) => {
          this.searchGameList();
        })
        .catch(({ response }) => {
          console.log(response);
        });
    } else {
      apiService
        .post("game-apply", apiParam)
        .then((response) => {
          console.log(response);
          this.searchGameList();
        })
        .catch((response) => {
          console.log(response);
        });
    }
  }
}

export default ReservationStore;
