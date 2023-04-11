import AppStore from "./AppStore";
import HomeStore from "./HomeStore";
import PlayerInfoStore from "./PlayerInfoStore";
import ReservationStore from "./ReservationStore";

class RootStore {
  constructor() {
    this.appStore = new AppStore(this);
    this.homeStore = new HomeStore(this);
    this.reservationStore = new ReservationStore(this);
    this.playerInfoStore = new PlayerInfoStore(this);
  }
}

const rootStore = new RootStore();
export default rootStore;
