import Layout from './component/layout/Layout';
import Header from "./component/layout/header/Header";
import Footer from "./component/layout/Footer";
import Main from "./component/main/Main";
import React from "react";

function App() {

  const logoWidth = 200;

  const header = <Header logoWidth={logoWidth} />
  const main = <Main logoWidth={logoWidth} />

  return (
    <Layout
      top={header}
      center={main}
      bottom={Footer()}
    />
  );
}

export default App;
