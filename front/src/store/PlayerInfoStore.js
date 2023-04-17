import { action, makeObservable, observable } from "mobx";
import apiService from "../services/ApiService";

class PlayerInfoStore {
  constructor(rootStore) {
    this.rootStore = rootStore;
    makeObservable(this, {
      info: observable,
      init: action,
      loginCheck: action,
    });
  }

  info = {};

  loginCheck() {
    return this.rootStore.appStore.loginCheck;
  }

  init() {
    apiService
      .get("player/my-info", {})
      .then((response) => {
        this.info = response.data;
      })
      .catch(({ response }) => {
        alert("test");
      });
  }
}

export default PlayerInfoStore;
