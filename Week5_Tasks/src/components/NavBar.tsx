import { HStack, Text, Image, SimpleGrid, Center } from '@chakra-ui/react'
import Pubg from '../assets/Pubg.png'
import DarkSwitch from './DarkSwitch'
import { Link } from 'react-router-dom'
import SlideBar from './SlideBar'
import React from 'react'

const NavBar = () => {
  return (
    <HStack justifyContent={'space-between'} px={'6'} backgroundColor={'#4158D0'}
    backgroundImage={'linear-gradient(43deg, #4158D0 0%, #C850C0 46%, #FFCC70 100%)'}
    >
      <Center>
        <SimpleGrid display={'flex'} alignItems={'center'} gridTemplateColumns={'auto auto'} justifyContent={'center'}> 
          <Image src={Pubg} alt="logo" boxSize={'90px'}/>
          <Link to={'/'}>
            <Text fontSize={'20px'} fontWeight={'bold'}>Welcome to the World Of Gaming</Text>
          </Link>
        </SimpleGrid>
      </Center>

      <SimpleGrid display={'flex'} alignItems={'center'} gridTemplateColumns={'auto auto'} spacing={2}>
        <DarkSwitch/>
        <SlideBar/>
      </SimpleGrid>   
    </HStack>
  )
}

export default NavBar
