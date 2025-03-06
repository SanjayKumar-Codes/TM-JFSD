import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App'
import './index.css'
import { ChakraProvider, ColorModeScript } from '@chakra-ui/react'
import Theme from "./Theme"



ReactDOM.createRoot(document.getElementById('root') as HTMLElement).render(
  <React.StrictMode>
    <ChakraProvider theme={Theme}>
      <ColorModeScript initialColorMode=''></ColorModeScript>
      <App />
    </ChakraProvider>
  </React.StrictMode>,
)
