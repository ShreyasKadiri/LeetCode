import React, {Component} from 'react';
import "bootstrap/dist/css/bootstrap.min.css"
import  {BrowserRouter as Router, Link, Route} from 'react-router-dom';


class App extends Component{
  render(){
  return (

    <Router>
    <div className="container">
      <h2> Mern Stack Todo App</h2>
    </div>
     </Router>


  );
}
}

export default App;
