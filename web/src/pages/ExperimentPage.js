export function ExperimentPage() {
    const officers = [
        { id: 20, name: 'Captain Piett', score: 10 },
        { id: 24, name: 'General Veers', score: 20 },
        { id: 56, name: 'Admiral Ozzel', score: 30 },
        { id: 88, name: 'Commander Jerjerrod', score: -5 }]

    const personnel= [
        { id: 20, name: 'Captain Piett', pilotingScore: 10, shootingScore: 10, isForceUser: true },
        { id: 24, name: 'General Veers', score: 20 },
        { id: 56, name: 'Admiral Ozzel', pilotingScore: 5, shootingScore: 20, isForceUser:true },
        { id: 88, name: 'Commander Jerjerrod', score: -5 }
    ];

    return <div>
        {JSON.stringify(officers)}
        {JSON.stringify(personnel)}
        {/*if (officers.length<=0) {<div>NO Officers!</div>*/}
        {officers.length>=0 && <div>more than 0 Officers</div>}
        <ol>
            {officers.map((el) =>
                <li>{el.name}</li>
            )
            }
        </ol>
        <div>Test</div>
    </div>;
}