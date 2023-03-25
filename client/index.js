const trafficDiv = document.getElementById('traffic-div')
const modal = document.getElementById('modal')
const closeModalLink = document.getElementById('close-modal')

const trafficContainer = (info, parentElem) => {
  const parent = document.createElement("div")
  const leftDiv = document.createElement("div")
  const h3 = document.createElement("h3")
  const h4 = document.createElement("h4")
  const h5 = document.createElement("h5")
  const startDate = document.createElement("p")
  const endDate = document.createElement("p")

  parent.className = "container"

  h3.textContent = `Road: ${info.closedRoadName}`
  h4.textContent = `Intersection road name: ${info.startIntersectionRoadName}`
  h5.textContent = `Area: ${info.localGovernmentArea}`
  startDate.textContent = `Start: ${info.duration.start}`
  endDate.textContent = `End: ${info.duration.end}`

  const rightDiv = document.createElement("div")
  const moreInfo = document.createElement("a")
  moreInfo.textContent = "More Info"
  moreInfo.addEventListener('click', () => {
    trafficDiv.classList.add('hide')
    modal.classList.remove('hide')
    modal.classList.add('modal')
  })

  rightDiv.append(moreInfo)
  leftDiv.append(h3)
  leftDiv.append(h4)
  leftDiv.append(h5)
  leftDiv.append(startDate)
  leftDiv.append(endDate)
  parent.append(leftDiv)
  parent.append(rightDiv)
  parentElem.append(parent)
}
// Test
const infotest = {
  closedRoadName: "Rainbow Road",
  startIntersectionRoadName: "Town Lane",
  localGovernmentArea: "Port Phillip",
  duration: {
    start: 'start',
    end: 'end'
  }
}

const infotest2 = {
  closedRoadName: "Rainbow Road2",
  startIntersectionRoadName: "Town Lanesx2",
  localGovernmentArea: "Port Phillip2",
  duration: {
    start: 'start',
    end: 'end'
  }
}

const data = [infotest, infotest2]
// End test data

data.map((elem) => trafficContainer(elem, trafficDiv))

closeModalLink.addEventListener('click', () => {
  trafficDiv.classList.remove('hide')
  modal.classList.add('hide')
  modal.classList.remove('modal')
})