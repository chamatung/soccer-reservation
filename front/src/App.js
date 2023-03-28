import { inject } from "mobx-react";
import { observer } from "mobx-react-lite";
import Home from "./components/layout/Home";
import Main from "./components/layout/Main";
import Login from "./components/login/Login";
import Regist from "./components/login/Regist";

const App = inject("appStore")(
  observer(({ appStore }) => {
    let component = <div>잠시만 기다려봥</div>;
    // let registCheck = window.location.pathname === "/regist" ? true : false;
    let registPath = window.location.pathname === "/regist" ? true : false;
    let loginPath = window.location.pathname === "/login" ? true : false;
    let loginCheck = appStore.loginCheck;
    console.log(loginCheck);
    if (!loginCheck) {
      console.log("5");
      if (registPath) {
        console.log("2");
        component = <Regist />;
      } else {
        window.history.pushState("", "", `\login`);
        component = <Login />;
      }
    } else {
      console.log("3");
      component = <Main />;
    }

    return (
      <div className='App'>
        {component}
        <></>
        <></>
        <></>
      </div>
    );
  })
);

export default App;
