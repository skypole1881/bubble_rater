import React from 'react';
import {HashRouter, Switch, Route, Link} from 'react-router-dom'
// import logo from './logo.svg';
import './App.css';
// import 'https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.js'
// import 'https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.css'
import 'semantic-ui/dist/semantic.min.css';
import './me.css';
import ListContainer from './component/ListContainer'
import Post from './component/Post'

function Header() {
  return (
    <div>
      <nav className="ui inverted attached segment m-padded-tb-mini m-shadow-small" >
        <div className="ui container">
          <div className="ui inverted secondary stackable menu">
            <h2 className="ui teal header item">管理後台</h2>
            <Link to="/list" className=" m-item item m-mobile-hide active"><i className="mini home icon"></i>店家</Link>
            <Link to="/list" className=" m-item item m-mobile-hide active"><i className="mini home icon"></i>文章</Link>
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
      // <HashRouter>
      <div>
        {/* <Switch> */}
          <Route path="/list" component={ListContainer}/>
          <Route path="/post/:id" render={(props) => <Post {...props}/>}/>
          <Route exact path="/post" component={Post}/>
        {/* </Switch> */}
      </div>
      // </HashRouter>
    )
  }
}

function App() {
  return (
    <HashRouter>
      <Header/>
      <div className="ui attached pointing menu">
        <div className="ui container">
          <div className="right menu">
            <Link to="/list" className="teal item">列表</Link>
            <Link to="/post" className="teal item">新增</Link>
          </div>
        </div>
      </div>
      <div className="m-container-small m-padded-tb-big">
        <div className="ui container">
          <MainContent />
        </div>
      </div>
    </HashRouter>
  );
}

export default App;
