import { useState } from "react";
import ReactDOM from "react-dom/client";
import Search from "./components/Search";
import Footer from "./components/Footer";
import Body from "./components/Body";
const App = () => {
  const [searchText, setSearchText] = useState("");
  const [buttonClicked, setButtonClick] = useState(false);
  return (
    <>
      <Search
        search={searchText}
        setSearch={setSearchText}
        setButtonClick={setButtonClick}
        buttonClick={buttonClicked}
      />
      <Body search={searchText} buttonClick={buttonClicked} />
      <Footer />
    </>
  );
};

const root = document.querySelector("#root");
const rootElement = ReactDOM.createRoot(root);
rootElement.render(<App />);
