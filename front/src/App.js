import { inject } from "mobx-react";
import { observer } from "mobx-react-lite";
import Main from "./components/layout/Main";
import Login from "./components/login/Login";
import ManagerRegist from "./components/login/ManagerRegist";
import Regist from "./components/login/Regist";

const App = inject("appStore")(
  observer(({ appStore }) => {
    let component = <div>잠시만 기다려봥</div>;
    let registPath = window.location.pathname === "/regist" ? true : false;
    let managerRegistPath =
      window.location.pathname === "/managerRegist" ? true : false;

    let loginCheck = appStore.loginCheck;

    if (!loginCheck) {
      if (registPath) {
        component = <Regist />;
      } else if (managerRegistPath) {
        component = <ManagerRegist />;
      } else {
        component = <Login />;
        window.history.pushState("", "", `/login`);
      }
    } else {
      component = <Main />;
    }

    return <div className='App'>{component}</div>;
  })
);

export default App;
