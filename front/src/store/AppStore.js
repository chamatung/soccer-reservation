import { action, makeObservable, observable } from "mobx";

class AppStore {
  loginCheck = false;
  email = "";
  name = "";

  constructor(rootStore) {
    this.rootStore = rootStore;

    makeObservable(this, {
      loginCheck: observable,
      email: observable,
      name: observable,
      changeData: action,
      loginCheckChange: action,
      handleLogout: action,
    });
  }

  changeData(key, value) {
    this[key] = value;
  }

  loginCheckChange(check) {
    this.loginCheck = check;
  }

  handleLogout() {
    this.email = "";
    this.name = "";
    this.loginCheck = false;
  }

  get player() {
    const player = { email: this.email, name: this.name };
    return player;
  }
}

export default AppStore;
