const App = () => {

    const a = 10
    const b = 20
    const age = 21

    const friends = [
        {name: 'Sam', age:24},
        {name: 'Maya', age:19}
    ]

    const Hello = (props) => {
        return (
            <div>
                <p>Hello {props.name}, you are {props.age} years old.</p>
            </div>
        )
    }

    console.log(a+b)


    return (
        <div>
            <h1>Greetings</h1>
            <Hello name='Timothy' age={age} />
            <Hello name='Billson' age={a+b} />
            <p>Hello {friends[0].name}, you are {friends[0].age} years old.</p>
            <p>Hello {friends[1].name}, you are {friends[1].age} years old.</p>

        </div>
    )


}

export default App
