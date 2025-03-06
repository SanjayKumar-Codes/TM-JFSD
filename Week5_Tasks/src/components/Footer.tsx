import { SimpleGrid, Box, Text, HStack, Icon } from "@chakra-ui/react"
import React from "react"
import { FaFacebook, FaTwitter, FaInstagram } from "react-icons/fa"

const Footer = () => {
  return (
    <SimpleGrid justifyItems={'center'} w='100%' minChildWidth='260px' p={6} gap={6} minHeight={'105.5px'} backgroundColor={'gray.700'} color={'white'}>
      <Box>
        <Text fontSize='lg' fontWeight='bold'>Game Store</Text>
        <Text>© 2025 Gaming Website.</Text>
        <Text>All rights reserved.</Text>
      </Box>
      <Box textAlign={'center'}>
        <Text> Life is a game 🎮, and every level brings new challenges 💪.</Text>
        <Text> Play ▶️ it well, enjoy every moment ✨ </Text> 
        <Text >  And </Text>
        <Text>Never stop leveling up 📈.</Text>
      </Box>
      <Box justifyContent={'center'}>
        <Text fontSize='lg' fontWeight='bold' px={'16'}>Links</Text>
        <Box display={'flex'}>
          <ul>
          <li><Text px={'2'}>Home</Text></li>
          <li><Text px={'2'}>About</Text></li>
          <li><Text px={'2'}>Contact</Text></li>
          </ul>
        </Box>
      </Box>
      
    </SimpleGrid>
  )
}

export default Footer
