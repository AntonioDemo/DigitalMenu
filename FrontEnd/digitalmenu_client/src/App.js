import React, { useState } from "react";
import "./App.css";
import CarrelloContext from "./context/CarrelloContext";
import VistaMenu from "./view/VistaMenu";

let carrello = {
  prova: 123,
  ciao: "cas",
};

function App() {
  const [carelloContext, setCarrelloContext] = useState(carrello);

  return (
    <div className="App">
      <CarrelloContext.Provider value={[carelloContext, setCarrelloContext]}>
        <VistaMenu></VistaMenu>
      </CarrelloContext.Provider>
    </div>
  );
}

export default App;
