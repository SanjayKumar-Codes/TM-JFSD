// import ButtonComponent from "./components/ButtonComponent"
import NavBar from "./components/NavBar"
import { Grid, GridItem } from '@chakra-ui/react'
import GamingCard from "./components/GameCard"
import Footer from "./components/Footer"
import { Routes, Route, BrowserRouter } from 'react-router-dom'
import GameDetails from "./components/GameDetails"
import React from "react"
function App() {

  return (
    <BrowserRouter>  
      <Grid templateAreas={`"nav nav" "aside main"`} >
        <GridItem area={'nav'}  bg={"teal"} >
          <NavBar />
        </GridItem>
      </Grid>  
      <Routes>
        <Route path="/" element={ <GamingCard />} />
        <Route path="details/:resId" element={<GameDetails/>}/>
      </Routes>       
      <Footer />
    </BrowserRouter>
    
  )
}

export default App
