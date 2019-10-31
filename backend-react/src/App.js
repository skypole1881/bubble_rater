import React from 'react';
// import logo from './logo.svg';
import './App.css';
// import 'https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.js'
// import 'https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.css'
import 'semantic-ui/dist/semantic.min.css';
import './me.css';
import List from './component/List'
import Post from './component/Post'

function Header() {
  return (
    <div>
      <nav className="ui inverted attached segment m-padded-tb-mini m-shadow-small" >
        <div className="ui container">
          <div className="ui inverted secondary stackable menu">
            <h2 className="ui teal header item">管理後台</h2>
            <a href="/admin/blogs.html" className=" m-item item m-mobile-hide active"><i className="mini home icon"></i>博客</a>
            <div className="right m-item m-mobile-hide menu">
              <div className="ui dropdown  item">
                <div className="text"></div>
                <i className="dropdown icon"></i>
                <div className="menu">
                  <a href="./logout" className="item">註銷</a>
                </div>
              </div>
            </div>
          </div>
          <a href="#" className="ui menu toggle black icon button m-right-top m-mobile-show">
            <i className="sidebar icon"></i>
          </a>
        </div>
      </nav>
    </div>
  );
}

class MainContent extends React.Component {
  constructor(props){
    super(props);
  }
  render () {
    return (
      <div>
        <List/>
        <Post id = "1" />
      </div>
    )
  }
}

function App() {
  return (
    <div>
      <Header/>
      <div className="ui attached pointing menu">
        <div className="ui container">
          <div className="right menu">
            <a href="./blogs.html" className="teal active item">列表</a>
          </div>
        </div>
      </div>

      <div className="m-container-small m-padded-tb-big">
        <div className="ui container">
          <div  className="ui secondary segment form">
            <input type="hidden" name="page" />
            <div className="inline fields">
              <div className="field">
                <input type="text" name="title" placeholder="標題" />
              </div>
              <div className="field">
                <div className="ui labeled action input">
                  <div className="ui type selection "></div>
                </div>
              </div>
              <div className="field">
                <div className="ui checkbox"></div>
              </div>
              <div className="field">
                <button  type="button" id="search-btn" className="ui mini teal basic button"><i className="search icon"></i>搜索</button>
              </div>
            </div>
          </div>
          <div id="table-container">
            <MainContent />
          </div>
        </div>
      </div>
    </div>
  );
}

export default App;
