import React, { useContext } from "react";
import "./App.css";
import CarrelloContext from "./context/CarrelloContext";
import VistaMenu from "./view/VistaMenu";

function App() {
  let cConttext = useContext(CarrelloContext);
  return (
    <div className="App">
      <CarrelloContext.Provider value={cConttext}>
        <VistaMenu></VistaMenu>
      </CarrelloContext.Provider>
    </div>
  );
}

export default App;
