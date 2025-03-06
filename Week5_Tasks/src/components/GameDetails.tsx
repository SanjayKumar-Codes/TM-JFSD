import { GridItem,Image, Stack,Heading, HStack, Tag, TagLeftIcon, TagLabel, StackDivider, Box ,Text, Badge, SimpleGrid} from "@chakra-ui/react";
import axios from "axios";
import React from "react";
import { useEffect, useState } from "react"
import { FaStar } from "react-icons/fa";
import { IoIosAdd } from "react-icons/io";
// import { ListFormat } from "typescript";


const GameDetails = () => {

  const [gameid, setId] = useState(Number);
  const [details,setDetails] = useState(Object);
  useEffect(() => {   
    setId(Number(window.location.pathname.split('/')[2]));
    fetchData(gameid)
  }, [gameid]);

  const fetchData  = async(gameid: number) => {
    const result = await axios.get(`https://api.rawg.io/api/games/${gameid}?key=706ba3379c0f4e52a2edd66931a84657`)
    setDetails(result.data)
  }
  console.log(details)
  return (
      <GridItem w='100%' p={4} >
        <GridItem display={'flex'}>
          <Image src={details.background_image} alt='Segun Adebayo' w='50%' objectFit='contain' objectPosition={'0px 15%'} borderRadius={'10px'} mr={1} />
          <Image src={details.background_image_additional} alt='Segun Adebayo'w='50%' objectFit='contain' objectPosition={'0px 15%'} borderRadius={'10px'} ml={1} />
        </GridItem>
        
        <Stack mt={'5'} spacing='3'>
            <Heading size='lg'>{details.name}</Heading>
        </Stack>
        <HStack spacing={1} pt={2}>
            <Tag size='lg' variant='subtle' colorScheme='cyan'>
                <TagLeftIcon boxSize='18px' as={IoIosAdd} />
                <TagLabel>{details.suggestions_count}</TagLabel>
            </Tag>
            <Tag size='lg'>
              <TagLeftIcon boxSize='15px' as={FaStar} style={{ color: 'gold' }} />
              <TagLabel>{details.rating}</TagLabel>
            </Tag>
        </HStack>
        <Stack display={'flex'} flexDirection={'row'} pt={3} spacing='1'>
            <Text fontSize='lg' color={'orange.300'}>Release Date:</Text>
            <Text fontSize='lg'>{details.released}</Text>
        </Stack>
        <SimpleGrid display={'flex'} py={4} >
          {details.genres && details.genres.map((item: any) => item && <Badge colorScheme='purple' fontSize='l' borderRadius={10} fontWeight='bold' px={4} py={1} mr={4}>{item.name}</Badge>)}
        </SimpleGrid>
        <Text p={2} backgroundColor={'whiteAlpha.100'} >{details.description_raw}</Text>
      </GridItem>
  )
}


export default GameDetails
