import React from "react";
import Body from "../../components/Body/Body";
import SeccionCategoria from "../../components/Categoria/SeccionCategoria";
import SeccionHeader from '../../componentsHeader/SeccionHeader';

const Home = () => {
 
  return (
    <>
      <SeccionHeader />
      <Body>
        <SeccionCategoria />
      </Body>
    </>
  );
};

export default Home;
