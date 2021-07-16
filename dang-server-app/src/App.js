import "bootstrap/dist/css/bootstrap.min.css";
import { Route } from "react-router-dom";
import Footer from "./components/includes/Footer";
import Header from "./components/includes/Header";
import chat from "./pages/chat/chat";
import Home from "./pages/Home";
import Insert from "./pages/prouct/Insert";
import List from "./pages/prouct/List";
import Update from "./pages/prouct/Update";
import View from "./pages/prouct/View";

function App() {
  return (
    <div>
      <Header />
      <Route path="/" exact={true} component={Home} />
      <Route path="/product/list" exact={true} component={List} />
      <Route path="/product/insert" exact={true} component={Insert} />
      <Route path="/product/view/:itemid" exact={true} component={View} />
      <Route path="/product/update/:itemid" exact={true} component={Update} />
      <Route path="/hello/chat" exact={true} component={chat} />
      <Footer />
    </div>
  );
}

export default App;
