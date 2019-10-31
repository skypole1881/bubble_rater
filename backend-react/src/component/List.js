import React from 'react';
// import logo from './logo.svg';
import 'semantic-ui/dist/semantic.min.css';

class List extends React.Component {
  constructor(props){
    super(props);
        this.state = {
            numberofpage: 1,
            stores: [],
        }
  }
  componentDidMount() {
    fetch('http://13.230.125.32:8080/v1/bubble/detail/list')
        .then(res => res.json())
        .then((data) => {
            this.setState({ stores: data })
            console.log(this.state.stores)
        })
        .catch()
  }
  render () {
    return (
      <table className="ui compact teal table">
        <thead>
          <tr>
            <th>編號</th>
            <th>品牌</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          {
            this.state.stores.map(
              (store, index) => (
                <tr>
                  <td>{index}</td>
                  <td>{store.id}</td>
                  <td>
                    <a href={"/admin/blogs/"+store.id+"/input(id="+store.id+")"} className="ui mini teal basic button">編輯</a>
                    <a href={"/admin/blogs/"+store.id+"/delete(id="+store.id+")"} className="ui mini red basic button">刪除</a>
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