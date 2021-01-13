import React, { useState, useEffect, useContext } from "react";
import ItemDetProdotto from "../components/ItemDetProdotto";
import ItemProdotto from "../components/ItemProdotto";
import CarrelloContext from "../context/CarrelloContext";
import DigitalMenuService from "../services/DigitalMenuService";

function VistaProdotti() {
  const [carrelloContext] = useContext(CarrelloContext);
  const [prodotti, setProdotti] = useState([]);
  const [dettProdotto, setDetProdotto] = useState([]);
  const [isHidden, setisHidden] = useState(true);

  function mostraDettaglioProdotto() {
    if (isHidden) {
      setisHidden(false);
    } else {
      setisHidden(true);
    }
  }

  useEffect(() => {
    let b = DigitalMenuService.getProdotto(carrelloContext.prodottoSelezionato);
    b.then((res) => {
      setDetProdotto(res.data);
    });
  }, [carrelloContext.prodottoSelezionato]);

  useEffect(() => {
    let a = DigitalMenuService.getAllProdottiByCategoria(
      carrelloContext.categoriaSelezionata
    );
    a.then((res) => {
      setProdotti(res.data);
    });
  }, [carrelloContext.categoriaSelezionata]);

  return (
    <div>
      {console.log("DETTAGLIO PRODOTTO STATE", dettProdotto)}
      <ItemDetProdotto
        funSetHidden={mostraDettaglioProdotto}
        setHidden={isHidden}
        nome={dettProdotto.nome}
        prezzo={dettProdotto.prezzo}
        listIng={dettProdotto.listaIngredienti}
        foto={dettProdotto.foto}
      />
      {console.log(prodotti)}
      {prodotti.map((value, i) => {
        return (
          <ItemProdotto
            key={i}
            id={value.prodottoId}
            funSetHidden={mostraDettaglioProdotto}
            nome={value.nome}
            foto={value.foto}
            prezzo={value.prezzo}
          />
        );
      })}
    </div>
  );
}

export default VistaProdotti;
