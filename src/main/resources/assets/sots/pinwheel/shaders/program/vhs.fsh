#version 410 core

uniform sampler2D DiffuseSampler;
in vec2 texCoord;
out vec4 fragColor;

uniform float time;

// Desaturation
vec3 desaturate(vec3 color, float factor) {
    float gray = dot(color, vec3(0.299, 0.587, 0.114));
    return mix(color, vec3(gray), factor);
}

// Zufallsfunktion (simple hash)
float rand(float x) {
    return fract(sin(x) * 43758.5453);
}

// Sehr seltener horizontaler Glitch-Effekt
vec2 glitchUV(vec2 uv, float time) {
    float glitchFreq = 0.00000000000000005;
    float line = floor(uv.y * 15.0); // mehr Linien, noch seltenerer Effekt
    float glitchChance = rand(line + floor(time * 1.5));

    if (glitchChance < glitchFreq) {
        float offset = (rand(line * 1.7) - 0.5) * 0.02; // dezenter Offset ±0.02
        uv.x += offset;
    }

    return uv;
}

void main() {
    vec2 uv = texCoord;

    // Minimaler VHS-Glitch (sehr selten)
    uv = glitchUV(uv, time);

    // Bild abrufen
    vec3 color = texture(DiffuseSampler, uv).rgb;

    // Leichte Desaturation
    color = desaturate(color, 0.3);

    fragColor = vec4(color, 1.0);
}