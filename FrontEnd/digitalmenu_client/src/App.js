import React, { useState } from "react";
import "./App.css";
import CarrelloContext from "./context/CarrelloContext";
import VistaMenu from "./view/VistaMenu";

let Carrello = {
  listaProdotti: [
    {
      prodotto: {
        nome: "DMA",
        prodottoId: 1,
        prezzo: 5,
      },
      quantita: 2,
      rimIng: "rimuovi un dma",
    },
    {
      prodotto: {
        nome: "DMA 2 ",
        prodottoId: 2,
        prezzo: 6,
      },
      quantita: 100,
      rimIng: "dma è bello",
    },
  ],
};

function App() {
  const [carelloContext, setCarrelloContext] = useState(Carrello);

  return (
    <div className="App">
      <CarrelloContext.Provider value={[carelloContext, setCarrelloContext]}>
        <VistaMenu></VistaMenu>
      </CarrelloContext.Provider>
    </div>
  );
}

export default App;
