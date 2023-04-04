import { action, makeObservable } from "mobx";

class HomeStore {
  constructor(rootStore) {
    this.rootStore = rootStore;
    makeObservable(this, {});
  }

  handleLogout() {
    this.rootStore.appStore.handleLogout();
  }

  get player() {
    const player = this.rootStore.appStore.player;
    return player;
  }
}

export default HomeStore;
