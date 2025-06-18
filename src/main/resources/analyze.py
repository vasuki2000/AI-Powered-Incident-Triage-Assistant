from flask import Flask, request, jsonify

app = Flask(__name__)

@app.route('/analyze', methods=['POST'])
def analyze_incidents():

    data = request.get_json()
    title = data.get("title", "").lower()
    description = data.get("description", " ").lower()

    if "network" in title or "latency" in description:
        category = "Network"
        action = "Reset the Network settings"

    else:
        category = "Application"
        action = "Restart the laptop"

    severity = "High" if "critical" in title or "down" in description else "Mdeium"

    return jsonify({

    "ai_category": category,
    "ai_severity0": severity,
    "ai_suggested_action": action

    })

if __name__ == '__main__':
    app.run(port=5001)