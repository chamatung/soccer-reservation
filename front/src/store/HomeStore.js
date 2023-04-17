import { action, makeObservable, observable } from "mobx";
import apiService from "../services/ApiService";

class HomeStore {
  constructor(rootStore) {
    this.rootStore = rootStore;
    makeObservable(this, {
      info: observable,
      loadPlayer: action,
    });
  }

  info = {};

  handleLogout() {
    this.rootStore.appStore.handleLogout();
  }

  loadPlayer() {
    apiService
      .get("player/my-info", {})
      .then((response) => {
        this.info = response.data;
        console.log(response.data);
      })
      .catch(({ response }) => {
        alert(response);
      });
  }
}

export default HomeStore;
