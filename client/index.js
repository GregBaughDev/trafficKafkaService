const trafficDiv = document.getElementById('traffic-div')

const trafficContainer = (info, parentElem) => {
  const parent = document.createElement("div")
  const leftDiv = document.createElement("div")
  const h3 = document.createElement("h3")
  const h4 = document.createElement("h4")
  const h5 = document.createElement("h5")
  const hr = document.createElement("hr")

  parent.className = "container"

  h3.textContent = `Road: ${info.closedRoadName}`
  h4.textContent = `Intersection road name: ${info.startIntersectionRoadName}`
  h5.textContent = `Area: ${info.localGovernmentArea}`

  const rightDiv = document.createElement("div")
  const moreInfo = document.createElement("a")
  moreInfo.innerHtml = "More Info"
  moreInfo.href = "www.google.com"
  rightDiv.append(moreInfo)
  leftDiv.append(h3)
  leftDiv.append(h4)
  leftDiv.append(h5)
  parent.append(leftDiv)
  parent.append(rightDiv)
  parent.append(hr)
  parentElem.append(parent)
}
// Test
const infotest = {
  closedRoadName: "Rainbow Road",
  startIntersectionRoadName: "Town Lane",
  localGovernmentArea: "Port Phillip"
}

const infotest2 = {
  closedRoadName: "Rainbow Road2",
  startIntersectionRoadName: "Town Lanesx2",
  localGovernmentArea: "Port Phillip2"
}

const data = [infotest, infotest2]
// End test data

data.map((elem) => trafficContainer(elem, trafficDiv))