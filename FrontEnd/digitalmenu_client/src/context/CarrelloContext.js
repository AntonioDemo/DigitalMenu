import React from "react";

let Carrello = {
  categoriaSelezionata: 1,
  prodottoSelezionato: 1,
  metodoDiPagamento: 0,
  prezzoTotale: 0.0,
  listaProdotti: [],
};

const CarrelloContext = React.createContext(Carrello);

console.log("CARRELLOCONTEXT = ", Carrello);
export default CarrelloContext;
