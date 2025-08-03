import React from 'react'
import UserGreetings from './UserGreetings'
import GuestGreetings from './GuestGreetings'

function Greetings({isLoggedIn}) {
  return isLoggedIn ? <UserGreetings /> : <GuestGreetings />
}

export default Greetings;