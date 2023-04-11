import React from "react";
import { Route, Routes } from "react-router-dom";
import Home from "./Home";

import MenuBar from "./MenuBar";
import SocialReservation from "../reservation/SocialReservation";
import PlayerInfoPage from "../../test/PlayerInfoPage";

const Main = () => {
  return (
    <>
      <Home />
      <MenuBar />
      <Routes>
        <Route path='/' element={<SocialReservation />}></Route>
        <Route path='/main' element={<SocialReservation />}></Route>
        <Route path='/my-info' element={<PlayerInfoPage />}></Route>
      </Routes>
    </>
  );
};

export default Main;
