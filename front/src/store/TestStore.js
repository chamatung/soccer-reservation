import {
  action,
  computed,
  makeAutoObservable,
  observable,
  runInAction,
  toJS,
} from "mobx";

class TestStore {
  constructor(rootStore) {
    this.rootStore = rootStore;
  }
}

export default TestStore;
