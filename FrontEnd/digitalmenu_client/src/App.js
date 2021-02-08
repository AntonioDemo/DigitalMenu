import React, { useState, useContext } from "react";
import "./App.css";
import CarrelloContext from "./context/CarrelloContext";
import VistaMenu from "./view/VistaMenu";

function App() {
  const [carrelloContext, setContext] = useState(useContext(CarrelloContext));
  return (
    <div className="App">
      <CarrelloContext.Provider value={[carrelloContext, setContext]}>
        <VistaMenu></VistaMenu>
      </CarrelloContext.Provider>
    </div>
  );
}

export default App;
