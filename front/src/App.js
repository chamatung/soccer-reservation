import { inject } from "mobx-react";
import { observer } from "mobx-react-lite";
import Main from "./components/layout/Main";
import Login from "./components/login/Login";
import ManagerRegist from "./components/login/ManagerRegist";
import Regist from "./components/login/Regist";
import ManagerLogin from "./components/login/ManagerLogin";

const App = inject("appStore")(
  observer(({ appStore }) => {
    let component = <div>잠시만 기다려봥</div>;

    if (!appStore.loginCheck) {
      if (appStore.registPath) {
        component = <Regist />;
      } else {
        component = <Login />;
      }
    } else {
      component = <Main />;
    }

    return <div className='App'>{component}</div>;
  })
);

export default App;
