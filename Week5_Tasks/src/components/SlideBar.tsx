import React from 'react'
import {Drawer,DrawerBody,DrawerFooter,DrawerHeader,DrawerOverlay,DrawerContent,DrawerCloseButton,Button,useDisclosure,VStack,Link,Text} from "@chakra-ui/react"
import { MdOutlineMenu } from "react-icons/md";

const SideBar = () => {
  const { isOpen, onOpen, onClose } = useDisclosure()
  const btnRef = React.useRef(null)
  return (
    <>
      <Button ref={btnRef} onClick={onOpen} fontSize="30px" backgroundColor='transparent' >
        <MdOutlineMenu/>
      </Button>
      <Drawer isOpen={isOpen} placement="right" onClose={onClose} finalFocusRef={btnRef}>
        <DrawerOverlay />
        <DrawerContent>
          <DrawerCloseButton />
          <DrawerHeader>Navigation</DrawerHeader>
          <DrawerBody>
            <VStack align="start">
              <Link href="/" style={{textDecoration:"none"}} > Home</Link>
              <Link href="#" style={{textDecoration:"none"}}>About</Link>
              <Link href="#" style={{textDecoration:"none"}}>Contact</Link>
              <Link href="/" style={{textDecoration:"none"}}>Games</Link>
            </VStack>
          </DrawerBody>
          <DrawerFooter>
            <Text>© 2025 Gaming Website. All rights reserved.</Text>
          </DrawerFooter>
        </DrawerContent>
      </Drawer>
    </>
  )
}

export default SideBar