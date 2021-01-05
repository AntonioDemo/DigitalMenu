import axios from 'axios'


const IP = "127.0.0.1"

const URL = "http://" + IP + ":8080/";

class DigitalMenuService {


    getProva() {
        return axios.get(URL + "Prova");
    }

    getAllPiattiByCategoria() {
        return axios.get(URL + "GestionePiatti")
    }

}

export default new DigitalMenuService();