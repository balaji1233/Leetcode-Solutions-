class Solution {
    private enum EventType {
        
        START(1), // Flower start blooming
        VISIT(2), // Person visiting
        END(3); // Flower end blooming

        private int order;

        EventType(int order) {
            this.order = order;
        }

        public int getOrder() {
            return order;
        }
    }
    
    public class Event implements Comparable<Event> {
        
        private EventType eventType;
        private int time;
        private int position;

        public Event(EventType eventType, int time, int position) {
            this.eventType = eventType;
            this.time = time;
            this.position = position;
        }

        public EventType getEventType() {
            return eventType;
        }

        public int getTime() {
            return time;
        }
        
        public int getPosition() {
            return position;
        }

        @Override
        public int compareTo(Event other) {
            if(time < other.getTime()) {
                return -1;
            } else if(time > other.getTime()) {
                return 1;
            }
            return eventType.getOrder() - other.getEventType().getOrder();
        }
    }
    
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        List<Event> events = new ArrayList<Event>();
        for(int i = 0; i < flowers.length; i++) {
            int[] flower = flowers[i];
            events.add(new Event(EventType.START, flower[0], i));
            events.add(new Event(EventType.END, flower[1], i));
        }
        
        for(int i = 0; i < persons.length; i++) {
            events.add(new Event(EventType.VISIT, persons[i], i));
        }
        
        Collections.sort(events);
        
        int count = 0;
        int[] result = new int[persons.length];
        for(Event event : events) {
            if(event.getEventType().equals(EventType.START)) {
                count++;
            } else if(event.getEventType().equals(EventType.VISIT)) {
                result[event.getPosition()] = count;
            } else if(event.getEventType().equals(EventType.END)) {
                count--;
            }
        }
        return result;
    }
}
