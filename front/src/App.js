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
    let registPath = window.location.pathname === "/regist" ? true : false;
    let managerRegistPath =
      window.location.pathname === "/managerRegist" ? true : false;
    let managerLoginPath =
      window.location.pathname === "/manager-login" ? true : false;
    let loginCheck = appStore.loginCheck;
    let managerCheck = appStore.managerCheck;

    if (!loginCheck) {
      if (registPath) {
        component = <Regist />;
      } else if (managerRegistPath) {
        component = <ManagerRegist />;
      } else {
        if (!managerLoginPath) {
          component = <Login />;
        } else {
          component = <ManagerLogin />;
        }
      }
    } else {
      if (!managerCheck) {
        component = <Main />;
      } else {
        // component = <ManagerMain />
      }
    }

    return <div className='App'>{component}</div>;
  })
);

export default App;
