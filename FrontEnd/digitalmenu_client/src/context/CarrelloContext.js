import React from "react";

let Carrello = {
  categoriaSelezionata: 1,
  metodoDiPagamento: 0,
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

const CarrelloContext = React.createContext(Carrello);

console.log("CARRELLOCONTEXT = ", Carrello);
export default CarrelloContext;
