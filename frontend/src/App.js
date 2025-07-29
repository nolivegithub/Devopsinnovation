
import './App.css';
import * as React from 'react';
import { ScheduleComponent, Day, Week, WorkWeek, Month, Agenda, Inject, Resize, DragAndDrop } from '@syncfusion/ej2-react-schedule';
import { DataManager,  UrlAdaptor } from '@syncfusion/ej2-data';
import { ThemeProvider } from './contexts/ThemeContext';
import ThemeToggle from './components/ThemeToggle';

import "../node_modules/@syncfusion/ej2-base/styles/material.css";
import "../node_modules/@syncfusion/ej2-buttons/styles/material.css";
import "../node_modules/@syncfusion/ej2-calendars/styles/material.css";
import "../node_modules/@syncfusion/ej2-dropdowns/styles/material.css";
import "../node_modules/@syncfusion/ej2-inputs/styles/material.css";
import "../node_modules/@syncfusion/ej2-navigations/styles/material.css";
import "../node_modules/@syncfusion/ej2-popups/styles/material.css";
import "../node_modules/@syncfusion/ej2-schedule/styles/material.css";

function App() {
  const dataManager = new DataManager({
    url: '/api/scheduleevents/getData',
    crudUrl: '/api/scheduleevents/crudActions',
    adaptor: new UrlAdaptor(),
    crossDomain: true
});
  return (
    <ThemeProvider>
      <div className="App">
        <ThemeToggle />
        <ScheduleComponent width='100%' height='650px' currentView='Month' eventSettings={{ dataSource: dataManager,
       fields: {
        id: 'id',
        subject: { name: 'subject' },
        isAllDay: { name: 'isallday' },
        location: { name: 'location' },
        description: { name: 'description' },
        startTime: { name: 'starttime' },
        endTime: { name: 'endtime' },
        startTimezone: { name: 'starttimezone' },
        endTimezone: { name: 'endtimezone' },
        recurrenceID: {name:'recurrenceid'},
        recurrenceRule:{name:'recurrencerule'},
        recurrenceException: {name:'recurrenceexception'},
        followingID:{name:'followingid'}
      } }}>
              <Inject services={[Day, Week, WorkWeek, Month, Agenda, Resize, DragAndDrop]}/>
            </ScheduleComponent>
      </div>
    </ThemeProvider>
  );
}

export default App;
