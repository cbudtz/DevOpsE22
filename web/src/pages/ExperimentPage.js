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
    const id = officers.map((el)=>el.id);
    const totalScore = officers.reduce((acc,el)=>acc+el.score,0)
    const highscorers = officers.filter((el)=>el.score>10)
    const totalJediScore = personnel
        .filter((el)=>el.isForceUser)
        .map(el=>el.shootingScore+el.pilotingScore)
        .reduce((acc,el)=>acc+el,0)
    return <div>
        {JSON.stringify(officers)}
        {JSON.stringify(personnel)}
        <div>
            {JSON.stringify(id)}
        </div>
        <div>Totalscore: {totalScore}</div>
        <div>HighScorers:
            <ol>
                {highscorers.map((el) =>
                    <li>{el.name}:{el.score}</li>
                )
                }
            </ol>
        </div>
        <div>TotalJediScore: {totalJediScore}</div>

        <div>Test</div>
    </div>;
}