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
import JoinPage from "./pages/user/JoinPage";
import LoginPage from "./pages/user/LoginPage";
import UpdateUser from "./pages/user/UpdateUser";

function App() {
  return (
    <div>
      <Header />
      {/* product */}
      <Route path="/" exact={true} component={Home} />
      <Route path="/list" exact={true} component={List} />
      <Route path="/product/insert" exact={true} component={Insert} />
      <Route path="/view/:itemid" exact={true} component={View} />
      <Route path="/product/update/:itemid" exact={true} component={Update} />


      {/* user */}
      <Route path="/register" exact={true} component={JoinPage} />
      <Route path="/login" exact={true} component={LoginPage} />
      <Route path="/user/update" exact={true} component={UpdateUser} />

      {/* chat */}
      <Route path="/hello/chat" exact={true} component={chat} />

      <Footer />
    </div>
  );
}

export default App;
