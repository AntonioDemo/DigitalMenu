import React, { useState, useEffect } from "react";
import ItemDetProdotto from "../components/ItemDetProdotto";
import ItemProdotto from "../components/ItemProdotto";
import DigitalMenuService from "../services/DigitalMenuService";

function VistaProdotti() {
  const [prodotti, setProdotti] = useState([]);
  const [isHidden, setisHidden] = useState(true);

  //TEst
  let detProdotto = {
    prodottoId: 2,
    prezzo: 6.0,
    foto:
      "DigitalMenu/BackEnd/DigitalMenu_Server/foto/gran-crispy--isolated.png",
    nome: "Gran Crispy McBacon",
    listaIngredienti: [
      {
        nomeIng: "pane",
        ingredienteId: 1,
        isRimovibile: 0,
      },
      {
        nomeIng: "Carne  bovina",
        ingredienteId: 5,
        isRimovibile: 0,
      },
      {
        nomeIng: "Formaggio",
        ingredienteId: 6,
        isRimovibile: 1,
      },
      {
        nomeIng: "Bacon",
        ingredienteId: 7,
        isRimovibile: 0,
      },
      {
        nomeIng: "Salsa Crispy",
        ingredienteId: 8,
        isRimovibile: 1,
      },
    ],
  };

  function mostraDettaglioProdotto() {
    console.log("sono stato evocato");
    console.log(detProdotto);
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
      <ItemDetProdotto
        funSetHidden={mostraDettaglioProdotto}
        setHidden={isHidden}
        nome={detProdotto.nome}
        prezzo={detProdotto.prezzo}
        listIng={detProdotto.listaIngredienti}
      />
      {prodotti.map((value, i) => {
        return (
          <ItemProdotto
            key={i}
            funSetHidden={mostraDettaglioProdotto}
            nome={value.id}
          />
        );
      })}
    </div>
  );
}

export default VistaProdotti;
