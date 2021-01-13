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
  const [idp, setidp] = useState();
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

  function Prova(props) {
    useEffect(() => {
      let a = DigitalMenuService.getProdotto(props.id);
      a.then((res) => setDetProdotto(res.data));
    }, []);
  }

  useEffect(() => {
    let a = DigitalMenuService.getAllProdottiByCategoria(
      carrelloContext.categoriaSelezionata
    );
    a.then((res) => setProdotti(res.data));
  }, [carrelloContext.categoriaSelezionata]);

  return (
    <div>
      <ItemDetProdotto
        funSetHidden={mostraDettaglioProdotto}
        setHidden={isHidden}
        nome={detProdotto.nome}
        prezzo={detProdotto.prezzo}
        listIng={detProdotto.listaIngredienti}
        foto={detProdotto.foto}
      />
      {console.log(prodotti)}
      {prodotti.map((value, i) => {
        return (
          <div
            key={i}
            onClick={() => {
              <Prova id={value.prodottoId}></Prova>;
              setidp(value.prodottoId);
              alert(value.prodottoId);
              console.log("det proddd", dettProdotto);
            }}
          >
            <ItemProdotto
              key={i}
              funSetHidden={mostraDettaglioProdotto}
              nome={value.nome}
              foto={value.foto}
              prezzo={value.prezzo}
            />
          </div>
        );
      })}
    </div>
  );
}

export default VistaProdotti;
