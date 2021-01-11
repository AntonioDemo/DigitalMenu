import React, { useState, useEffect } from "react";
import ItemDetProdotto from "../components/ItemDetProdotto";
import ItemProdotto from "../components/ItemProdotto";
import DigitalMenuService from "../services/DigitalMenuService";

function VistaProdotti() {
  const [prodotti, setProdotti] = useState([]);
  const [isHidden, setisHidden] = useState(true);

  function mostraDettaglioProdotto() {
    console.log("sono stato evocato");
    if (isHidden) {
      setisHidden(false);
    } else {
      setisHidden(true);
    }
  }

  useEffect(() => {
    let a = DigitalMenuService.getAllProdottiByCategoria();
    a.then((res) => setProdotti(res.data));
  }, []);

  return (
    <div>
      <ItemDetProdotto myFunc={mostraDettaglioProdotto} setHidden={isHidden} />
      {prodotti.map((value, i) => {
        return (
          <ItemProdotto
            key={i}
            myFunc={mostraDettaglioProdotto}
            nome={value.id}
          />
        );
      })}
    </div>
  );
}

export default VistaProdotti;
