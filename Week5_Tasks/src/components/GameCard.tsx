import { Badge, Card, CardBody, CardHeader, GridItem, HStack, Link, SimpleGrid, StackDivider, Tag, TagLabel, TagLeftIcon } from '@chakra-ui/react'
import { Button, ButtonGroup,Box, Text, Heading, Image, Stack } from '@chakra-ui/react'
import { useEffect, useState } from 'react'
import { IoIosAdd } from "react-icons/io";
import { FaStar } from "react-icons/fa";
import axios from 'axios'
import React from 'react';
const GameCard = () => {
    
    const pageSize = 3;
    const[page,setPage] = useState(1)
    

    const [response, getData] = useState([])

    useEffect(() => {
        
        const fetchData = async() => {
            const result = await axios.get('https://api.rawg.io/api/games?key=706ba3379c0f4e52a2edd66931a84657')
            getData(result.data.results)
        }
        fetchData()
    },[])

    const startRange = (page - 1) * pageSize
    const endRange = startRange + pageSize
    const visibleItems = response.slice(startRange, endRange)
    
  return (
    <>
    <SimpleGrid w='100%' minChildWidth='260px'  p={20} gap={20}>
        {visibleItems.map((item:object,key) => (
            <GridItem w='100%' key={key}>
                <Card maxW='sm' boxShadow={'4px 4px 15px rgb(0,0,0,0.95)'} >
                    <CardHeader>
                        <Image src={item.background_image} alt='Segun Adebayo' h={'200px'} objectFit='cover' />
                        <Stack mt='6' spacing='3'>
                        <Heading size='sm'>{item.name}</Heading>
                        </Stack>
                        <HStack spacing={1} pt={2}>
                            <Tag size='sm' variant='subtle' colorScheme='cyan'>
                                <TagLeftIcon boxSize='18px' as={IoIosAdd} />
                                <TagLabel>{item.suggestions_count}</TagLabel>
                            </Tag>
                            <Tag size='sm'>
                                <TagLeftIcon boxSize='15px' as={FaStar} style={{ color: 'gold' }} />
                                <TagLabel>{item.rating}</TagLabel>
                            </Tag>
                        </HStack>
                    </CardHeader>
                    <CardBody id={key.toString()} >
                        <Stack px={2} divider={<StackDivider />} spacing='1'>
                            <Box display={'flex'} justifyContent={'space-between'}>
                                <Text fontSize='sm'>Release Date:</Text>
                                <Text fontSize='sm'>{item.released}</Text>
                            </Box>
                            <Box display={'flex'} justifyContent={'space-between'}>
                                <Text fontSize='sm'>Genres</Text>
                                <GridItem fontSize='sm'>
                                    {item.genres.map((genre:any,index:number) => (
                                        <Badge key={index} display={'inline'} mx={'1'} colorScheme='purple'>{genre.name} </Badge>
                                    ))}
                                </GridItem>
                            </Box>
                        </Stack>
                        <Stack px={2} py={2} >
                            <ButtonGroup display={'flex'} justifyContent={'space-between'}>
                                <Button variant='ghost' colorScheme='green' >
                                    Buy now
                                </Button>
                                <Link  href={`/details/${item.id}`} >
                                    <Button variant='ghost' colorScheme='orange'>
                                        View Details
                                    </Button>
                                </Link>
                            </ButtonGroup>
                        </Stack>                       
                    </CardBody>
                </Card>
            </GridItem>
        ))}      
    </SimpleGrid>
    <SimpleGrid display={'flex'} justifyContent={'center'}>
  <Button m={'4'} onClick={() => page > 1 ? setPage(page - 1) : null} 
    backgroundColor={'#00DBDE'}
    backgroundImage={'linear-gradient(90deg, #00DBDE 0%, #FC00FF 100%)'}>Prev</Button>
  <Button m={'4'} onClick={() => page < Math.floor(response.length / pageSize) ? setPage(page + 1) : null} 
    backgroundColor={'#00DBDE'}
    backgroundImage={'linear-gradient(90deg, #00DBDE 0%, #FC00FF 100%)'}>Next</Button>
</SimpleGrid>

    
    </>
  )
}

export default GameCard
