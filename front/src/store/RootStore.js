import TestStore from "./TestStore";

class RootStore {
  constructor() {
    this.testStore = new TestStore(this);
  }
}

const rootStore = new RootStore();
export default rootStore;
