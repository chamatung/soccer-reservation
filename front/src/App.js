import Home from "./components/layout/Home";
import Main from "./components/layout/Main";
import Login from "./components/login/Login";
import Regist from "./components/login/Regist";

function App() {
  let component = <div>잠시만 기다려봥</div>;
  // let registCheck = window.location.pathname === "/regist" ? true : false;
  let registPath = window.location.pathname === "/regist" ? true : false;
  let loginPath = window.location.pathname === "/login" ? true : false;
  let loginCheck = true;
  if (loginCheck) {
    component = <Login />;
  } else {
    component = <Main />;
  }

  if (loginPath) {
    component = <Login />;
  }
  if (registPath) {
    component = <Regist />;
  }
  return (
    <div className='App'>
      {component}
      <></>
      <></>
      <></>
    </div>
  );
}

export default App;
