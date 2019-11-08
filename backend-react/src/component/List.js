import React from 'react';
import {Link} from 'react-router-dom'
// import logo from './logo.svg';
import 'semantic-ui/dist/semantic.min.css';

class List extends React.Component {
  constructor(props){
    super(props);
    this.state = {
        numberofpage: 1,
        stores: [],
    }
    this.deleteStore = this.deleteStore.bind(this);
    this.getStores = this.getStores.bind(this);
  }
  componentDidMount() {
    this.getStores();
  }
  getStores() {
    fetch('http://13.230.125.32:8080/v1/bubble/detail/list')
      .then(res => res.json())
      .then((data) => {
          this.setState({ stores: data })
          console.log(this.state.stores)
      })
      .catch()
  }
  deleteStore(id) {
    console.log("delete "+ id);
    fetch('http://13.230.125.32:8080/v1/bubble/detail/' + id, {
      method: 'delete'
    })
    .then((res) => {console.log(res)})
    .then(() => this.getStores())
    .catch();
  }
  render () {
    return (
      <table className="ui compact teal table">
        <thead>
          <tr>
            <th></th>
            <th>店名</th>
            <th>地區</th>
            <th>品名</th>
            <th>創建時間</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          {
            this.state.stores.map(
              (store, index) => (
                <tr key={store.id}>
                  <td>{index + 1}</td>
                  <td>{store.name}</td>
                  <td>{store.country+" "+store.city+" "+store.district}</td>
                  <td>{store.item}</td>
                  <td>{store.createdDtm}</td>
                  <td>
                    <Link to={"/post/"+store.id} className="ui mini teal basic button">編輯</Link>
                    <Link to="/list" onClick={() => {this.deleteStore(store.id)}} className="ui mini red basic button">刪除</Link>
                  </td>
                </tr>
              )
            )
          }
        </tbody>
      </table>
    )
  }
}

export default List;