import { action, makeObservable, observable } from "mobx";
import apiService from "../services/ApiService";

class ReservationStore {
  week = ["일", "월", "화", "수", "목", "금", "토"];
  nowYear = "";
  nextYear = "";
  nowMonth = "";
  nextMonth = "";
  nowDays = [];
  nextDays = [];
  today = new Date();
  currentDayInfo = {};

  gameList = [];

  constructor(rootStore) {
    this.rootStore = rootStore;
    makeObservable(this, {
      week: observable,
      nowYear: observable,
      nextYear: observable,
      nowMonth: observable,
      nextMonth: observable,
      currentDayInfo: observable,
      nowDays: observable,
      nextDays: observable,
      today: observable,
      gameList: observable,
      dateCalculation: action,
      nowDaysArray: action,
      nextDaysArray: action,
      searchGameList: action,
    });
  }

  init() {
    this.dateCalculation();
    this.searchGameList(this.currentDayInfo);
  }

  //다음달은 30일- 이번달 나온 일수로만 하기 2월 포함하는 경우는 28일까지만 윤년의 경우도 체크할 것
  dateCalculation() {
    let today = this.today;
    let nowDays = [];
    let nextDays = [];
    this.currentDay = today.getDate();
    this.nowMonth = today.getMonth() + 1;
    this.nowYear = today.getFullYear();

    if (this.nowMonth === 12) {
      this.nextMonth = 1;
      this.nextYear = this.nowYear + 1;
    } else {
      this.nextMonth = this.nowMonth + 1;
    }

    let nextStartDayCnt;
    if (this.nowMonth in [1, 3, 5, 7, 8, 10, 12]) {
      nowDays = Array.from(
        { length: 31 - today.getDate() },
        (v, i) => i + today.getDate()
      );
    } else if (today.getMonth() + 1 in [2, 4, 6, 9, 11]) {
      if (today.getMonth + 1 === 2) {
        let length;
        if (!this.leapYearCheck()) {
          length = 28 - today.getDate();
        } else {
          length = 29 - today.getDate();
        }
        nowDays = Array.from({ length: length }, (v, i) => i + today.getDate());
      } else {
        nowDays = Array.from(
          { length: 30 - today.getDate() },
          (v, i) => i + today.getDate()
        );
      }
    }

    const nowDaysArray = this.nowDaysArray(nowDays);
    nowDays = nowDaysArray.days;
    nextStartDayCnt = nowDaysArray.nextCnt;

    this.nowDays = nowDays;
    if (today.getDate() !== 1) {
      nextDays = this.nextDaysArray(
        today,
        nowDaysArray.length,
        nextStartDayCnt
      );
      this.nextDays = nextDays;
    }

    const dayInfo = {
      day: today.getDate(),
      month: this.nowMonth,
      year: this.nowYear,
    };

    this.currentDayInfo = dayInfo;
  }
  //이번달 정보
  nowDaysArray(days) {
    let startDayCnt = this.today.getDay() - 1;

    const newDays = days.map((nowDay, index) => {
      startDayCnt += 1;
      if (startDayCnt > 6) {
        startDayCnt = 0;
      }
      return {
        date: nowDay,
        day: this.week[startDayCnt],
      };
    });
    return {
      days: newDays,
      nextCnt: startDayCnt > 6 ? 1 : startDayCnt + 1,
      length: newDays.length,
    };
  }
  //다음달 정보
  nextDaysArray(today, nowDaysLength, nextStartDayCnt) {
    let nextDays = [];
    if (today.getMonth() + 1 === 1 && today.getDate() in [30, 31]) {
      nextDays = Array.from({ length: 28 - nowDaysLength }, (v, i) => i + 1);
    } else {
      nextDays = Array.from({ length: 30 - nowDaysLength }, (v, i) => i + 1);
    }
    nextStartDayCnt -= 1;
    const newNextDays = nextDays.map((nextDay, index) => {
      nextStartDayCnt += 1;
      if (nextStartDayCnt > 6) {
        nextStartDayCnt = 0;
      }
      return {
        date: nextDay,
        day: this.week[nextStartDayCnt],
      };
    });
    return newNextDays;
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

  searchGameList(dayInfo) {
    const apiParam = dayInfo;
    apiService
      .get("game/list", apiParam)
      .then(({ data }) => {
        console.log(data);
        this.gameList = data;
      })
      .catch(({ response }) => {
        console.log(response);
      });
  }
}

export default ReservationStore;
