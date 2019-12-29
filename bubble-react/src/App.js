import React from 'react';
import {StyleRoot} from 'radium';
import { BrowserRouter as Router, Route, Link} from 'react-router-dom';
import './App.css';
import './single-store.css'
import './blog-home.css'
import './post.css'
import {Navbar} from './components/Navbar'
import Header from './components/Header'
import MainContent from './components/MainContent'
import News from './components/news/News'

import { library } from '@fortawesome/fontawesome-svg-core'
import { fab } from '@fortawesome/free-brands-svg-icons'
import { faCheckSquare, faCoffee } from '@fortawesome/free-solid-svg-icons'
 
library.add(fab, faCheckSquare, faCoffee)

function App() {
  return (
    <div>
      <Router>
          <Navbar />
          <Route exact path="/">
            <MainContent/>
          </Route>
          <Route path="/newsandcoupons">
            <News/>
          </Route>
      </Router>
    </div>
   
  )
}

export default App;
