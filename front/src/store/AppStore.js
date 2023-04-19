import { action, makeObservable, observable } from "mobx";

class AppStore {
  loginCheck = false;
  registPath = window.location.pathname === "/regist" ? true : false;
  managerCheck = false;

  constructor(rootStore) {
    this.rootStore = rootStore;

    makeObservable(this, {
      loginCheck: observable,
      registPath: observable,
      changeData: action,
      handleLoginCheck: action,
      handleLogout: action,
    });
  }

  changeData(key, value) {
    this[key] = value;
  }

  handleLoginCheck() {
    this.loginCheck = localStorage.getItem("token") ? true : false;
  }

  handleLogout() {
    localStorage.removeItem("token");
    this.loginCheck = false;
  }
}

export default AppStore;
